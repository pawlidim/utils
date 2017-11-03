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

import de.pawlidi.utils.message.Interpolator;

/**
 * Implementation of the ILog interface using the interpolation.
 * 
 * @author PAWLIDIM
 *
 */
final class Log implements ILog {

	private LogProvider log;
	private String category;

	/**
	 * Invisible default constructor to construct new Log for given category.
	 * 
	 * @param category
	 */
	Log(String category) {
		this.category = category;
		this.log = Logging.getLogProvider(category, true);
	}

	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	public boolean isErrorEnabled() {
		return log.isErrorEnabled();
	}

	public boolean isFatalEnabled() {
		return log.isFatalEnabled();
	}

	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	public boolean isWarnEnabled() {
		return log.isWarnEnabled();
	}

	public void trace(Object object, Object... params) {
		if (isTraceEnabled()) {
			log.trace(interpolate(object, params));
		}
	}

	public void trace(Object object, Throwable t, Object... params) {
		if (isTraceEnabled()) {
			log.trace(interpolate(object, params), t);
		}
	}

	public void debug(Object object, Object... params) {
		if (isDebugEnabled()) {
			log.debug(interpolate(object, params));
		}
	}

	public void debug(Object object, Throwable t, Object... params) {
		if (isDebugEnabled()) {
			log.debug(interpolate(object, params), t);
		}
	}

	public void info(Object object, Object... params) {
		if (isInfoEnabled()) {
			log.info(interpolate(object, params));
		}
	}

	public void info(Object object, Throwable t, Object... params) {
		if (isInfoEnabled()) {
			log.info(interpolate(object, params), t);
		}
	}

	public void warn(Object object, Object... params) {
		if (isWarnEnabled()) {
			log.warn(interpolate(object, params));
		}
	}

	public void warn(Object object, Throwable t, Object... params) {
		if (isWarnEnabled()) {
			log.warn(interpolate(object, params), t);
		}
	}

	public void error(Object object, Object... params) {
		if (isErrorEnabled()) {
			log.error(interpolate(object, params));
		}
	}

	public void error(Object object, Throwable t, Object... params) {
		if (isErrorEnabled()) {
			log.error(interpolate(object, params), t);
		}
	}

	public void fatal(Object object, Object... params) {
		if (isFatalEnabled()) {
			log.fatal(interpolate(object, params));
		}
	}

	public void fatal(Object object, Throwable t, Object... params) {
		if (isFatalEnabled()) {
			log.fatal(interpolate(object, params), t);
		}
	}

	private Object interpolate(Object object, Object... params) {
		if (String.class.isInstance(object)) {
			try {
				object = Interpolator.instance().interpolate((String) object, params);
			} catch (Exception e) {
				log.error("Exception interpolating string: " + object, e);
			}
		}
		return object;
	}
}
