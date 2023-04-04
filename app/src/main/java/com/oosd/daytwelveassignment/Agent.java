package com.oosd.daytwelveassignment;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Agent implements Serializable
{
    private int AgentId;
    private String AgtFirstName;
    private String AgtMiddleName;
    private String AgtLastName;
    private String AgtBusPhone;
    private String AgtEmail;
    private String AgtPosition;
    private int AgencyId;

    public Agent(int agentId, String agtFirstName, String agtMiddleName, String agtLastName,
                 String agtBusPhone, String agtEmail, String agtPosition, int agencyId)
    {
        AgentId = agentId;
        AgtFirstName = agtFirstName;
        AgtMiddleName = agtMiddleName;
        AgtLastName = agtLastName;
        AgtBusPhone = agtBusPhone;
        AgtEmail = agtEmail;
        AgtPosition = agtPosition;
        AgencyId = agencyId;
    }

    @NonNull
    @Override
    public String toString()
    {
        return AgentId + "";
    }

    public int getAgentId()
    {
        return AgentId;
    }

    public void setAgentId(int agentId)
    {
        AgentId = agentId;
    }

    public String getAgtFirstName()
    {
        return AgtFirstName;
    }

    public void setAgtFirstName(String agtFirstName)
    {
        AgtFirstName = agtFirstName;
    }

    public String getAgtMiddleName()
    {
        return AgtMiddleName;
    }

    public void setAgtMiddleName(String agtMiddleName)
    {
       AgtMiddleName = agtMiddleName;
    }

    public String getAgtLastName()
    {
        return AgtLastName;
    }

    public void setAgtLastName(String agtLastName)
    {
        AgtLastName = agtLastName;
    }

    public String getAgtBusPhone()
    {
        return AgtBusPhone;
    }

    public void setAgtBusPhone(String agtBusPhone)
    {
        AgtBusPhone = agtBusPhone;
    }

    public String getAgtEmail()
    {
        return AgtEmail;
    }

    public void setAgtEmail(String agtEmail)
    {
        AgtEmail = agtEmail;
    }

    public String getAgtPosition()
    {
        return AgtPosition;
    }

    public void setAgtPosition(String agtPosition)
    {
        AgtPosition = agtPosition;
    }

    public int getAgencyId()
    {
        return AgencyId;
    }

    public void setAgencyId(int agencyId)
    {
        AgencyId = agencyId;
    }
}
