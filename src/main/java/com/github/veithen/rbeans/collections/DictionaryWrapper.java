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

import java.util.Dictionary;
import java.util.Enumeration;

import com.github.veithen.rbeans.ObjectHandler;
import com.github.veithen.rbeans.RBean;

@SuppressWarnings("unchecked")
public class DictionaryWrapper extends Dictionary {
    private final ObjectHandler keyHandler;
    private final ObjectHandler valueHandler;
    private final Dictionary parent;
    
    public DictionaryWrapper(ObjectHandler keyHandler, ObjectHandler valueHandler, Dictionary parent) {
        this.keyHandler = keyHandler;
        this.valueHandler = valueHandler;
        this.parent = parent;
    }
    
    @Override
    public Enumeration elements() {
        return new EnumerationWrapper(valueHandler, parent.elements());
    }

    @Override
    public Object get(Object key) {
        if (key instanceof RBean) {
            key = ((RBean)key)._getTargetObject();
        }
        return valueHandler.handle(parent.get(key));
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public Enumeration keys() {
        return new EnumerationWrapper(keyHandler, parent.keys());
    }

    @Override
    public Object put(Object key, Object value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(Object key) {
        if (key instanceof RBean) {
            key = ((RBean)key)._getTargetObject();
        }
        return valueHandler.handle(parent.remove(key));
    }

    @Override
    public int size() {
        return parent.size();
    }
}
