/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.pax.logging;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.PatternLayoutEncoderBase;

/**
 * Adds the ability to use %node in an encoder pattern
 *
 * @since 3.7
 */
public class NexusLayoutEncoder
    extends PatternLayoutEncoderBase<ILoggingEvent>
{
  @Override
  public void start() {
    PatternLayout patternLayout = new PatternLayout();
    patternLayout.getDefaultConverterMap().put("node", NexusNodeNameConverter.class.getName());
    patternLayout.setContext(context);
    patternLayout.setPattern(getPattern());
    patternLayout.start();
    this.layout = patternLayout;
    super.start();
  }
}
