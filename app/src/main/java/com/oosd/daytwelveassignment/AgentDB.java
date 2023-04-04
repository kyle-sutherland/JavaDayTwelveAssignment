package com.oosd.daytwelveassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import androidx.viewpager.widget.PagerTabStrip;

import java.util.ArrayList;

public class AgentDB
{
    private Context context;
    private SQLiteDatabase db;
    private DBHelper helper;
    private String[] columns = {"AgtName", "AgtMiddleInitial", "AgtLastName",
                                "AgtBusPhone", "AgtEmail", "AgtPosition", "AgencyId"};

    public AgentDB(Context context)
    {
        this.context = context;
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    private ContentValues createContentValues(Agent agent)
    {
        ContentValues cv = new ContentValues();
        cv.put("AgtFirstName", agent.getAgtFirstName());
        cv.put("AgtMiddleName", agent.getAgtMiddleName());
        cv.put("AgtLastName", agent.getAgtLastName());
        cv.put("AgtBusPhone", agent.getAgtBusPhone());
        cv.put("AgtEmail", agent.getAgtEmail());
        cv.put("AgtPosition", agent.getAgtPosition());
        cv.put("AgencyId", agent.getAgencyId());
        return cv;
    }

    public Agent getAgent(int agentId)
    {
        Agent agent = null;
        String[] args = {agentId + ""};

        Cursor cursor = db.query("Agents", columns, "AgentId=?", args,
                null, null, null);
        if(cursor.moveToNext())
        {
            agent = new Agent(agentId, cursor.getString(0), cursor.getString(1),
                    cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getInt(6));
        }
        else
        {
            Log.d("kyle", "no agent found with id: " + agentId);
        }
        return agent;
    }

    public ArrayList<Agent> getAllAgents()
    {
        ArrayList<Agent> list = new ArrayList<>();

        Cursor cursor = db.query("Agents", columns,
                null, null, null, null, null);
        while (cursor.moveToNext())
        {
            list.add(new Agent(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getInt(7)));
        }
        return list;
    }

    public void insertAgent(Agent agent)
    {
        ContentValues cv = createContentValues(agent);
        long rowId = db.insert("Agents", null, cv);
        if(rowId == -1)
        {
            Log.d("kyle", "insert failed");
            Toast.makeText(context, "insert failed", Toast.LENGTH_LONG).show();
        }
        else
        {
            Log.d("kyle", "insert successful");
            Toast.makeText(context, "insert successful", Toast.LENGTH_LONG).show();
        }
    }

    public void updateAgent(Agent agent)
    {
        ContentValues cv = createContentValues(agent);
        String[] args = {agent.getAgentId() + ""};
        String where = "AgentId=?";
        long rowId = db.update("Agents", cv, where, args);
        if(rowId == -1)
        {
            Log.d("kyle", "update failed");
            Toast.makeText(context, "update failed", Toast.LENGTH_LONG).show();
        }
        else
        {
            Log.d("kyle", "update successful");
            Toast.makeText(context, "update successful", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteAgent(int agentId)
    {
        String[] args = {agentId + ""};
        String where = "AgentId=?";
        long rowId = db.delete("Agents", where, args);
        if(rowId == -1)
        {
            Log.d("kyle", "delete failed");
            Toast.makeText(context, "delete failed", Toast.LENGTH_LONG).show();
        }
        else
        {
            Log.d("kyle", "delete successful");
            Toast.makeText(context, "delete successful", Toast.LENGTH_LONG).show();
        }
    }
}
