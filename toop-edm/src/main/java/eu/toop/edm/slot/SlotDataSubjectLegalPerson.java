/**
 * Copyright (C) 2018-2021 toop.eu. All rights reserved.
 *
 * This project is dual licensed under Apache License, Version 2.0
 * and the EUPL 1.2.
 *
 *  = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
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
 *
 *  = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 *
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved
 * by the European Commission - subsequent versions of the EUPL
 * (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 *         https://joinup.ec.europa.eu/software/page/eupl
 */
package eu.toop.edm.slot;

import javax.annotation.Nonnull;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;

import eu.toop.edm.model.BusinessPojo;
import eu.toop.edm.xml.cv.BusinessMarshaller;
import eu.toop.regrep.rim.SlotType;
import eu.toop.regrep.slot.ISlotProvider;
import eu.toop.regrep.slot.SlotBuilder;

/**
 * DataSubject "LegalPerson" slot
 *
 * @author Philip Helger
 */
public class SlotDataSubjectLegalPerson implements ISlotProvider
{
  public static final String NAME = "LegalPerson";

  private final BusinessPojo m_aLegalPerson;

  public SlotDataSubjectLegalPerson (@Nonnull final BusinessPojo aLegalPerson)
  {
    ValueEnforcer.notNull (aLegalPerson, "LegalPerson");
    m_aLegalPerson = aLegalPerson;
  }

  @Nonnull
  @Nonempty
  public String getName ()
  {
    return NAME;
  }

  @Nonnull
  public SlotType createSlot ()
  {
    return new SlotBuilder ().setName (NAME)
                             .setValue (new BusinessMarshaller ().getAsDocument (m_aLegalPerson.getAsCoreBusiness ()).getDocumentElement ())
                             .build ();
  }
}
