/*
 * Created on Nov 29, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions.api.intarray;

import static junit.framework.Assert.assertSame;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Comparator;

import org.fest.assertions.api.IntArrayAssert;
import org.fest.assertions.api.IntArrayAssertBaseTest;
import org.fest.assertions.internal.Objects;
import org.junit.Before;
import org.mockito.Mock;

/**
 * Tests for <code>{@link IntArrayAssert#usingElementComparator(Comparator)}</code>.
 * 
 * @author Joel Costigliola
 * @author Mikhail Mazursky
 */
public class IntArrayAssert_usingElementComparator_Test extends IntArrayAssertBaseTest {

  @Mock
  private Comparator<Integer> comparator;

  private Objects objectsBefore;

  @Before
  public void before() {
    initMocks(this);
    objectsBefore = getObjects(assertions);
  }

  @Override
  protected IntArrayAssert invoke_api_method() {
    // in that test, the comparator type is not important, we only check that we correctly switch of comparator
    return assertions.usingElementComparator(comparator);
  }

  @Override
  protected void verify_internal_effects() {
    assertSame(getObjects(assertions), objectsBefore);
    assertSame(getArrays(assertions).getComparator(), comparator);
  }
}
