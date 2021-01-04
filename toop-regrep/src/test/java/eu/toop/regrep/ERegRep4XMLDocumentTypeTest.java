/**
 * Copyright (C) 2020-2021 toop.eu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.toop.regrep;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.helger.commons.io.resource.ClassPathResource;

/**
 * Test class for class {@link ERegRep4XMLDocumentType}.
 *
 * @author Philip Helger
 */
public class ERegRep4XMLDocumentTypeTest
{
  @Test
  public void testBasic ()
  {
    for (final ERegRep4XMLDocumentType e : ERegRep4XMLDocumentType.values ())
    {
      assertNotNull (e.getImplementationClass ());
      assertNotNull (e.getAllXSDResources ());
      for (final ClassPathResource r : e.getAllXSDResources ())
        assertTrue (r.exists ());
    }
  }
}
