Introduction to RBeans
----------------------

An RBean is a Java object that interacts with another Java object (the "target") using reflection.
The RBean corresponding to a given target class is specified by an interface extending `RBean` or
`StaticRBean` and annotated with `@Target` or `@TargetClass`.
Each method declared by that interface corresponds to a method or attribute of
the target class. These methods and attributes may be private or protected. An RBean can
therefore be used to get access to non public members of a class. While this is the most important
use case for RBeans, there are a couple of others:

* RBeans can be used to interact with APIs that are not available at build time.
  This is useful for Open Source projects if the JAR containing the API may not be
  distributed freely. An example are projects that need to support proprietary APIs
  exposed by application servers such as WebSphere or Weblogic.

* RBeans can be used to support different versions of an API with incompatible changes
  between versions.

* A component can use RBeans to interact with instances of classes loaded by a foreign
  class loader, i.e. a class loader that is not an ancestor of the class loader from which
  the component is loaded.

The following sample illustrates how RBeans work. Assume that you need to inject a class definition
into an existing class loader. This can easily be done by invoking the `defineClass` method on
that class loader. However, since that method is protected, it can only be invoked using
reflection. To do this with an RBean, one would define the following interface:

    @TargetClass(ClassLoader.class)
    public interface ClassLoaderRBean extends RBean {
        Class<?> defineClass(String name,
                             byte[] b,
                             int off,
                             int len)
                        throws ClassFormatError;
    }

RBeans are instantiated using a factory, which requires a list of one or more RBean interfaces.
In our case:

    RBeanFactory rbf = new RBeanFactory(ClassLoaderRBean.class);

The `createRBean` method is then used to create an RBean instance for a given target object:

    ClassLoader cl = ...
    ClassLoaderRBean rbean
        = rbf.createRBean(ClassLoaderRBean.class, cl);

Compared to simple reflection, RBeans have the following advantages:

* They improve the readability of the code.

* They have a higher level of type safety. The reason is that reflection is done
  when the RBeanFactory is created. At the same time, the necessary checks are done
  to make sure that the methods declared in the RBean interface are compatible with the
  corresponding members of the target class.

Invoking methods through an RBean
---------------------------------

To be able to invoke a method of the target class through the RBean interface, simply
add a corresponding method to the RBean. The method must have the same signature, but
the return type may be replaced by a corresponding RBean. In that case, the returned
object will automatically be substituted with the appropriate RBean. Note that the
type of the RBean to be created is determined at runtime, i.e. inheritance relationships
are preserved. However, for this to work, all relevant RBean types must be known to the
RBeanFactory. To ensure this, specify the RBean types in the list passed to the constructor
of the `RBeanFactory` or use the `@SeeAlso` annotation.

Accessing attributes through an RBean
-------------------------------------

To access attributes of the target object through an RBean, define a method on the
RBean interface and annotate it with the `@Accessor` annotation.

`@Mapped`
---------

In some cases, it is useful to replace objects returned by a method with their corresponding
RBeans, while passing through objects for which no RBean exists. Consider for example a
method with return type `Object`. At runtime, if the method returns a `String`,
then no substitution is necessary. However, one might still want to substitute the returned
object by an RBean for particular types of instances. To achieve this, add the `@Mapped`
annotation to the method. Note however that this only works if one of the following
conditions is satisfied:
  
* The return type of the method is `Object`.
  
* The return type of the method is an interface and the relevant RBeans extend this
  interface.

The `@Mapped` annotation is also supported on attribute accessors.

Collections
-----------
  
Automatically wrapping returned objects as RBeans is also supported for collections.
To enable this, declare the return type as `Iterable<T>`, where `T` is an RBean interface.

Accessing static attributes and methods
---------------------------------------

In order to access static attributes and methods of a given target class, create an
RBean interface that extends `StaticRBean`. When creating the
RBean instance, use the variant of the `createRBean` method that doesn't take
an instance parameter.

Limitations and known issues
----------------------------

* While Java 5 generics are fully supported, the checks done to ensure compatibility between
  the RBean interface and the target class are not exhaustive with respect to parameterized
  types.