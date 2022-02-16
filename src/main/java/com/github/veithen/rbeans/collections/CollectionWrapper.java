/*-
 * #%L
 * RBeans
 * %%
 * Copyright (C) 2010 - 2018 Andreas Veithen
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.github.veithen.rbeans.collections;

import java.util.Collection;

import com.github.veithen.rbeans.ObjectHandler;

@SuppressWarnings("unchecked")
public class CollectionWrapper extends IterableWrapper implements Collection {

    public CollectionWrapper(ObjectHandler objectHandler, Collection parent) {
        super(objectHandler, parent);
    }

    @Override
    public boolean add(Object o) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        // TODO
        throw new UnsupportedOperationException();
    }
}
