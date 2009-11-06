/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.caelum.vraptor.deserialization;

import java.lang.annotation.Annotation;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.StereotypeHandler;

/**
 * Handles classes annotated with @Deserializes
 *
 * @author Lucas Cavalcanti, Cecilia Fernandes
 */
@ApplicationScoped
public class DeserializesHandler implements StereotypeHandler {

	private final Deserializers deserializers;

	public DeserializesHandler(Deserializers deserializers) {
		this.deserializers = deserializers;
	}

	@SuppressWarnings("unchecked")
	public void handle(Class<?> type) {
		if (!Deserializer.class.isAssignableFrom(type)) {
			throw new IllegalArgumentException(type + " must implement Deserializer");
		}
		deserializers.register((Class<? extends Deserializer>) type);
	}

	public Class<? extends Annotation> stereotype() {
		return Deserializes.class;
	}

}
