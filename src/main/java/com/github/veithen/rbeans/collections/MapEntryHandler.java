/*
 * Copyright 2010-2013 Andreas Veithen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.veithen.rbeans.collections;

import java.util.Map;

import com.github.veithen.rbeans.ObjectHandler;

@SuppressWarnings("unchecked")
public class MapEntryHandler extends ObjectHandler {
    private final ObjectHandler keyHandler;
    private final ObjectHandler valueHandler;

    public MapEntryHandler(ObjectHandler keyHandler, ObjectHandler valueHandler) {
        this.keyHandler = keyHandler;
        this.valueHandler = valueHandler;
    }

    @Override
    protected Object doHandle(Object object) {
        return new MapEntryWrapper(keyHandler, valueHandler, (Map.Entry)object);
    }
}