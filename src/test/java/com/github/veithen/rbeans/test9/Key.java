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
package com.github.veithen.rbeans.test9;

public class Key {
    private final String string;

    public Key(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Key) {
            return ((Key)obj).string.equals(string);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return string.hashCode();
    }
}
