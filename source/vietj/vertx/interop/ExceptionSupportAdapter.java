/*
 * Copyright 2013 Julien Viet
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
package vietj.vertx.interop;

import org.vertx.java.core.Handler;
import org.vertx.java.core.streams.ExceptionSupport;

import vietj.promises.Deferred;

public class ExceptionSupportAdapter {
	
	public static <T, U> void handle(ExceptionSupport<T> es, final Deferred<U> deferred) {
		es.exceptionHandler(new Handler<Throwable>() {
			@Override
			public void handle(Throwable t) {
				deferred.reject(t);
			}
		});
	}
}
