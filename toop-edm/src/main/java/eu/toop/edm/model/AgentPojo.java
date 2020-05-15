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
package eu.toop.edm.model;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.string.StringHelper;
import com.helger.commons.string.ToStringGenerator;

import eu.toop.edm.jaxb.cv.agent.AgentType;
import eu.toop.edm.jaxb.cv.agent.LocationType;
import eu.toop.edm.jaxb.cv.cac.AddressType;
import eu.toop.edm.jaxb.cv.cbc.IDType;
import eu.toop.edm.jaxb.cv.cbc.NameType;

/**
 * Represents an "Agent"
 *
 * @author Philip Helger
 */
public class AgentPojo
{
  private final String m_sID;
  private final String m_sIDSchemeID;
  private final String m_sName;
  private final AddressPojo m_aAddress;

  public AgentPojo (@Nullable final String sID,
                    @Nullable final String sIDSchemeID,
                    @Nullable final String sName,
                    @Nullable final AddressPojo aAddress)
  {
    m_sID = sID;
    m_sIDSchemeID = sIDSchemeID;
    m_sName = sName;
    m_aAddress = aAddress;
  }

  @Nullable
  public final String getID ()
  {
    return m_sID;
  }

  @Nullable
  public final String getIDSchemeID ()
  {
    return m_sIDSchemeID;
  }

  @Nullable
  public final String getName ()
  {
    return m_sName;
  }

  @Nullable
  public final AddressPojo getAddress ()
  {
    return m_aAddress;
  }

  @Nonnull
  public AgentType getAsAgent ()
  {
    final AgentType ret = new AgentType ();
    if (StringHelper.hasText (m_sID))
    {
      final IDType aID = new IDType ();
      aID.setValue (m_sID);
      aID.setSchemeID (m_sIDSchemeID);
      ret.addId (aID);
    }
    if (StringHelper.hasText (m_sName))
    {
      final NameType aName = new NameType ();
      aName.setValue (m_sName);
      ret.addName (aName);
    }
    if (m_aAddress != null)
    {
      final AddressType aAddress = m_aAddress.getAsAgentAddress ();
      if (aAddress != null)
      {
        final LocationType aLocation = new LocationType ();
        aLocation.setAddress (aAddress);
        ret.addLocation (aLocation);
      }
    }
    return ret;
  }

  @Override
  public boolean equals (final Object o)
  {
    if (o == this)
      return true;
    if (o == null || !getClass ().equals (o.getClass ()))
      return false;
    final AgentPojo rhs = (AgentPojo) o;
    return EqualsHelper.equals (m_sID, rhs.m_sID) &&
           EqualsHelper.equals (m_sIDSchemeID, rhs.m_sIDSchemeID) &&
           EqualsHelper.equals (m_sName, rhs.m_sName) &&
           EqualsHelper.equals (m_aAddress, rhs.m_aAddress);
  }

  @Override
  public int hashCode ()
  {
    return new HashCodeGenerator (this).append (m_sID)
                                       .append (m_sIDSchemeID)
                                       .append (m_sName)
                                       .append (m_aAddress)
                                       .getHashCode ();
  }

  @Override
  public String toString ()
  {
    return new ToStringGenerator (this).append ("ID", m_sID)
                                       .append ("IDSchemeID", m_sIDSchemeID)
                                       .append ("Name", m_sName)
                                       .append ("Address", m_aAddress)
                                       .getToString ();
  }

  @Nonnull
  public static Builder builder ()
  {
    return new Builder ();
  }

  @Nonnull
  public static Builder builder (@Nullable final AgentType a)
  {
    final Builder ret = new Builder ();
    if (a != null)
    {
      if (a.hasIdEntries ())
        ret.id (a.getIdAtIndex (0).getValue ()).idSchemeID (a.getIdAtIndex (0).getSchemeID ());
      if (a.hasNameEntries ())
        ret.name (a.getNameAtIndex (0).getValue ());
      if (a.hasLocationEntries ())
        ret.address (AddressPojo.builder (a.getLocationAtIndex (0).getAddress ()));
    }
    return ret;
  }

  public static class Builder
  {
    private String m_sID;
    private String m_sIDSchemeID;
    private String m_sName;
    private AddressPojo m_aAddress;

    public Builder ()
    {}

    @Nonnull
    public Builder id (@Nullable final String s)
    {
      m_sID = s;
      return this;
    }

    @Nonnull
    public Builder idSchemeID (@Nullable final String s)
    {
      m_sIDSchemeID = s;
      return this;
    }

    @Nonnull
    public Builder name (@Nullable final String s)
    {
      m_sName = s;
      return this;
    }

    @Nonnull
    public Builder address (@Nullable final AddressPojo.Builder a)
    {
      return address (a == null ? null : a.build ());
    }

    @Nonnull
    public Builder address (@Nullable final AddressPojo a)
    {
      m_aAddress = a;
      return this;
    }

    @Nonnull
    public AgentPojo build ()
    {
      return new AgentPojo (m_sID, m_sIDSchemeID, m_sName, m_aAddress);
    }
  }
}