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
package com.github.veithen.rbeans;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a member is not required to be present in the target class.
 * If the target member is not found, then an invocation of the method on the
 * RBean interface will return <code>null</code>.
 */
// TODO: if the method declares TargetMemberUnavailableException, then the invocation should throw that exception instead of returning null
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Optional {

}
