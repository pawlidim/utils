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
package de.pawlidi.utils.log;

/**
 * Logger factory provides methods to construct available logger instances.
 * 
 * @author PAWLIDIM
 *
 */
public final class Logging {

	private static final boolean isLog4JAvailable;
	private static final boolean isJBossLogAvailable;

	static {
		boolean available;
		try {
			Class.forName("org.apache.log4j.Logger");
			available = true;
		} catch (ClassNotFoundException cnfe) {
			available = false;
		}
		isLog4JAvailable = available;

		try {
			Class.forName("org.jboss.logging.Logger");
			available = true;
		} catch (ClassNotFoundException cnfe) {
			available = false;
		}
		isJBossLogAvailable = available;
	}

	/**
	 * Invisible logging constructor.
	 */
	private Logging() {
		super();
	}

	/**
	 * Returns available logger instance for given category.
	 * 
	 * @param category
	 * @return logger instance
	 */
	public static ILog getLog(String category) {
		return new Log(category);
	}

	/**
	 * Returns available logger instance for given class.
	 * 
	 * @param clazz
	 * @return logger instance
	 */
	public static ILog getLog(Class<?> clazz) {
		return new Log(clazz.getName());
	}

	/**
	 * Returns available logger provider instance for given category and wrapped
	 * flag.
	 * 
	 * @param category
	 * @param wrapped
	 * @return logger provider instance
	 */
	public static LogProvider getLogProvider(String category, boolean wrapped) {
		if (isJBossLogAvailable) {
			return new JBossLogProvider(category, wrapped);
		}
		return isLog4JAvailable ? new Log4JProvider(category, wrapped) : new JDKProvider(category, wrapped);
	}

	/**
	 * Returns available logger provider instance for given class.
	 * 
	 * @param clazz
	 * @return logger provider instance
	 */
	public static LogProvider getLogProvider(Class<?> clazz) {
		return getLogProvider(clazz.getName(), false);
	}
}
