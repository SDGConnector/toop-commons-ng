/**
 * Copyright (C) 2018-2020 toop.eu
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
package eu.toop.edm.slot;

import javax.annotation.Nonnull;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;

import eu.toop.edm.model.DatasetPojo;
import eu.toop.edm.xml.dcatap.DatasetMarshaller;
import eu.toop.regrep.rim.SlotType;
import eu.toop.regrep.slot.ISlotProvider;
import eu.toop.regrep.slot.SlotBuilder;

/**
 * "DocumentMetadata" slot
 *
 * @author Philip Helger
 */
public class SlotDocumentMetadata implements ISlotProvider
{
  public static final String NAME = "DocumentMetadata";

  private final DatasetPojo m_aDataset;

  public SlotDocumentMetadata (@Nonnull final DatasetPojo aDataset)
  {
    ValueEnforcer.notNull (aDataset, "Dataset");
    m_aDataset = aDataset;
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
                             .setValue (new DatasetMarshaller ().getAsDocument (m_aDataset.getAsDataset ()).getDocumentElement ())
                             .build ();
  }
}
