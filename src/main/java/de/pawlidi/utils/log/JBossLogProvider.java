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

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

/**
 * JBoss logger provider implementation.
 * 
 * @author PAWLIDIM
 *
 */
public final class JBossLogProvider implements LogProvider {

	private final Logger logger;
	private final boolean isWrapped;
	private static final String LOG_IMPL_FQCN = Log.class.getName();
	private static final String LOG_PROVIDER_FQCN = JBossLogProvider.class.getName();

	private static final Level TRACE;
	static {
		Object trace;
		try {
			trace = Level.class.getDeclaredField("TRACE").get(null);
		} catch (Exception e) {
			trace = Level.DEBUG;
		}
		TRACE = (Level) trace;
	}

	/**
	 * Invisible default constructor to construct new jboss logger provider.
	 * 
	 * @param category
	 * @param wrapped
	 */
	JBossLogProvider(String category, boolean wrapped) {
		logger = Logger.getLogger(category);
		isWrapped = wrapped;
	}

	public String getFQCN() {
		return isWrapped ? LOG_IMPL_FQCN : LOG_PROVIDER_FQCN;
	}

	public void debug(Object object) {
		logger.log(Level.DEBUG, getFQCN(), object, null);
	}

	public void debug(Object object, Throwable t) {
		logger.log(Level.DEBUG, getFQCN(), object, t);
	}

	public void error(Object object) {
		logger.log(Level.ERROR, getFQCN(), object, null);
	}

	public void error(Object object, Throwable t) {
		logger.log(Level.ERROR, getFQCN(), object, t);
	}

	public void fatal(Object object) {
		logger.log(Level.FATAL, getFQCN(), object, null);
	}

	public void fatal(Object object, Throwable t) {
		logger.log(Level.FATAL, getFQCN(), object, t);
	}

	public void info(Object object) {
		logger.log(Level.INFO, getFQCN(), object, null);
	}

	public void info(Object object, Throwable t) {
		logger.log(Level.INFO, getFQCN(), object, t);
	}

	public boolean isDebugEnabled() {
		return logger.isEnabled(Level.DEBUG);
	}

	public boolean isErrorEnabled() {
		return logger.isEnabled(Level.ERROR);
	}

	public boolean isFatalEnabled() {
		return logger.isEnabled(Level.FATAL);
	}

	public boolean isInfoEnabled() {
		return logger.isEnabled(Level.INFO);
	}

	public boolean isTraceEnabled() {
		return logger.isEnabled(TRACE);
	}

	public boolean isWarnEnabled() {
		return logger.isEnabled(Level.WARN);
	}

	public void trace(Object object) {
		logger.log(TRACE, getFQCN(), object, null);
	}

	public void trace(Object object, Throwable t) {
		logger.log(TRACE, getFQCN(), object, t);
	}

	public void warn(Object object) {
		logger.log(Level.WARN, getFQCN(), object, null);
	}

	public void warn(Object object, Throwable t) {
		logger.log(Level.WARN, getFQCN(), object, t);
	}
}
