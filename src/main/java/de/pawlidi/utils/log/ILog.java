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
 * A logger interface that integrates with internal message interpolation
 * functionality.
 * 
 * @author PAWLIDIM
 *
 */
public interface ILog extends Serializable {

	/**
	 * Logs a message and interpolated parameters with the TRACE level.
	 * 
	 * @param object
	 *            message to log
	 * @param params
	 *            message parameter to interpolate
	 */
	void trace(Object object, Object... params);

	/**
	 * Logs a message and interpolated parameters with the TRACE level including the
	 * stack trace of the Throwable object.
	 * 
	 * @param object
	 *            message to log
	 * @param t
	 *            as Throwable object
	 * @param params
	 *            message parameter to interpolate
	 */
	void trace(Object object, Throwable t, Object... params);

	/**
	 * Logs a message and interpolated parameters with the DEBUG level.
	 * 
	 * @param object
	 *            message to log
	 * @param params
	 *            message parameter to interpolate
	 */
	void debug(Object object, Object... params);

	/**
	 * Logs a message and interpolated parameters with the DEBUG level including the
	 * stack trace of the Throwable object.
	 * 
	 * @param object
	 *            message to log
	 * @param t
	 *            as Throwable object
	 * @param params
	 *            message parameter to interpolate
	 */
	void debug(Object object, Throwable t, Object... params);

	/**
	 * Logs a message and interpolated parameters with the INFO level.
	 * 
	 * @param object
	 *            message to log
	 * @param params
	 *            message parameter to interpolate
	 */
	void info(Object object, Object... params);

	/**
	 * Logs a message and interpolated parameters with the INFO level including the
	 * stack trace of the Throwable object.
	 * 
	 * @param object
	 *            message to log
	 * @param t
	 *            as Throwable object
	 * @param params
	 *            message parameter to interpolate
	 */
	void info(Object object, Throwable t, Object... params);

	/**
	 * Logs a message and interpolated parameters with the WARN level.
	 * 
	 * @param object
	 *            message to log
	 * @param params
	 *            message parameter to interpolate
	 */
	void warn(Object object, Object... params);

	/**
	 * Logs a message and interpolated parameters with the WARN level including the
	 * stack trace of the Throwable object.
	 * 
	 * @param object
	 *            message to log
	 * @param t
	 *            as Throwable object
	 * @param params
	 *            message parameter to interpolate
	 */
	void warn(Object object, Throwable t, Object... params);

	/**
	 * Logs a message and interpolated parameters with the ERROR level.
	 * 
	 * @param object
	 *            message to log
	 * @param params
	 *            message parameter to interpolate
	 */
	void error(Object object, Object... params);

	/**
	 * Logs a message and interpolated parameters with the ERROR level including the
	 * stack trace of the Throwable object.
	 * 
	 * @param object
	 *            message to log
	 * @param t
	 *            as Throwable object
	 * @param params
	 *            message parameter to interpolate
	 */
	void error(Object object, Throwable t, Object... params);

	/**
	 * Logs a message and interpolated parameters with the FATAL level.
	 * 
	 * @param object
	 *            message to log
	 * @param params
	 *            message parameter to interpolate
	 */
	void fatal(Object object, Object... params);

	/**
	 * Logs a message and interpolated parameters with the FATAL level including the
	 * stack trace of the Throwable object.
	 * 
	 * @param object
	 *            message to log
	 * @param t
	 *            as Throwable object
	 * @param params
	 *            message parameter to interpolate
	 */
	void fatal(Object object, Throwable t, Object... params);

	/**
	 * Checks whether this Logger is enabled for the DEBUG level.
	 * 
	 * @return boolean - true if this Logger is enabled for level DEBUG, false
	 *         otherwise.
	 */
	boolean isDebugEnabled();

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

	/**
	 * Checks whether this Logger is enabled for the INFO level.
	 * 
	 * @return boolean - true if this Logger is enabled for level INFO, false
	 *         otherwise.
	 */
	boolean isInfoEnabled();

	/**
	 * Checks whether this Logger is enabled for the TRACE level.
	 * 
	 * @return boolean - true if this Logger is enabled for level TRACE, false
	 *         otherwise.
	 */
	boolean isTraceEnabled();

	/**
	 * Checks whether this Logger is enabled for the WARN level.
	 * 
	 * @return boolean - true if this Logger is enabled for level WARN, false
	 *         otherwise.
	 */
	boolean isWarnEnabled();
}
