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
package com.github.veithen.rbeans;

import java.lang.reflect.Method;

public class SimpleMethodHandler implements MethodHandler {
    private final Method targetMethod;
    private final ObjectHandler resultHandler;

    public SimpleMethodHandler(Method targetMethod, ObjectHandler resultHandler) {
        this.targetMethod = targetMethod;
        this.resultHandler = resultHandler;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Throwable {
        return resultHandler.handle(targetMethod.invoke(target, args));
    }
}
