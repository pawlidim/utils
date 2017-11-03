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

import java.io.Serializable;

/**
 * Abstracts the underlying logging implementation (log4j, jboss logger or JDK
 * logging).
 * 
 * @author PAWLIDIM
 *
 */
public interface LogProvider extends Serializable {

	/**
	 * Returns the Fully-Qualified class name of underlying logger implementation.
	 * 
	 * @return fqcn
	 */
	String getFQCN();

	/**
	 * Logs a message object with the TRACE level.
	 * 
	 * @param object
	 *            as message
	 */
	void trace(Object object);

	/**
	 * Logs a message object with the TRACE level including the stack trace of the
	 * Throwable object.
	 * 
	 * @param object
	 *            as message
	 * @param t
	 *            as Throwable object
	 */
	void trace(Object object, Throwable t);

	/**
	 * Logs a message object with the DEBUG level.
	 * 
	 * @param object
	 *            as message
	 */
	void debug(Object object);

	/**
	 * Logs a message object with the DEBUG level including the stack trace of the
	 * Throwable object.
	 * 
	 * @param object
	 *            as message
	 * @param t
	 *            as Throwable object
	 */
	void debug(Object object, Throwable t);

	/**
	 * Logs a message object with the INFO level.
	 * 
	 * @param object
	 *            as message
	 */
	void info(Object object);

	/**
	 * Logs a message object with the INFO level including the stack trace of the
	 * Throwable object.
	 * 
	 * @param object
	 *            as message
	 * @param t
	 *            as Throwable object
	 */
	void info(Object object, Throwable t);

	/**
	 * Logs a message object with the WARN level.
	 * 
	 * @param object
	 *            as message
	 */
	void warn(Object object);

	/**
	 * Logs a message object with the TRACE level including the stack trace of the
	 * Throwable object.
	 * 
	 * @param object
	 *            as message
	 * @param t
	 *            as Throwable object
	 */
	void warn(Object object, Throwable t);

	/**
	 * Logs a message object with the ERROR level.
	 * 
	 * @param object
	 *            as message
	 */
	void error(Object object);

	/**
	 * Logs a message object with the ERROR level including the stack trace of the
	 * Throwable object.
	 * 
	 * @param object
	 *            as message
	 * @param t
	 *            as Throwable object
	 */
	void error(Object object, Throwable t);

	/**
	 * Logs a message object with the FATAL level.
	 * 
	 * @param object
	 *            as message
	 */
	void fatal(Object object);

	/**
	 * Logs a message object with the FATAL level including the stack trace of the
	 * Throwable object.
	 * 
	 * @param object
	 *            as message
	 * @param t
	 *            as Throwable object
	 */
	void fatal(Object object, Throwable t);

	/**
	 * Checks whether this Logger is enabled for the TRACE level.
	 * 
	 * @return boolean - true if this Logger is enabled for level TRACE, false
	 *         otherwise.
	 */
	boolean isTraceEnabled();

	/**
	 * Checks whether this Logger is enabled for the DEBUG level.
	 * 
	 * @return boolean - true if this Logger is enabled for level DEBUG, false
	 *         otherwise.
	 */
	boolean isDebugEnabled();

	/**
	 * Checks whether this Logger is enabled for the INFO level.
	 * 
	 * @return boolean - true if this Logger is enabled for level INFO, false
	 *         otherwise.
	 */
	boolean isInfoEnabled();

	/**
	 * Checks whether this Logger is enabled for the WARN level.
	 * 
	 * @return boolean - true if this Logger is enabled for level WARN, false
	 *         otherwise.
	 */
	boolean isWarnEnabled();

	/**
	 * Checks whether this Logger is enabled for the ERROR level.
	 * 
	 * @return boolean - true if this Logger is enabled for level ERROR, false
	 *         otherwise.
	 */
	boolean isErrorEnabled();

	/**
	 * Checks whether this Logger is enabled for the FATAL level.
	 * 
	 * @return boolean - true if this Logger is enabled for level FATAL, false
	 *         otherwise.
	 */
	boolean isFatalEnabled();
}
