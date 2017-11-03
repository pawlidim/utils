/*
 * Copyright (C) 2017 Maximilian Pawlidi
 *
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
 */
package de.pawlidi.utils.message;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * Interpolates EL expressions in strings.
 * 
 * @author PAWLIDIM
 *
 */
public final class Interpolator implements Serializable {

	protected volatile static Interpolator instance;

	/**
	 * Invisible default constructor to construct the interpolator.
	 */
	Interpolator() {
		super();
	}

	/**
	 * Return singleton interpolator instance.
	 * 
	 * @return instance
	 */
	public static Interpolator instance() {
		if (instance == null) {
			synchronized (Interpolator.class) {
				if (instance == null) {
					instance = new Interpolator();
				}
			}
		}
		return instance;
	}

	/**
	 * Replace all EL expressions in the form {...} with their evaluated values .
	 * 
	 * @param string
	 *            a template
	 * @return the interpolated string
	 */
	public String interpolate(String messageText, Object... arguments) {
		return interpolate(messageText, Locale.getDefault(), arguments);
	}

	/**
	 * Replace all EL expressions in the form {...} with their evaluated values and
	 * current locale.
	 * 
	 * @param string
	 *            a template
	 * @param locale
	 *            a locale
	 * @return the interpolated string
	 */
	public String interpolate(String messageText, Locale locale, Object... arguments) {
		MessageFormat messageFormat = new MessageFormat(messageText);
		messageFormat.setLocale(locale);
		return messageFormat.format(arguments);
	}

}
