package com.mrjaffesclass.apcs.todolist;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * To do item
 * 
 * @author Roger Jaffe
 * @version 1.0
 */
public class ToDoItem {

  /**
   * id:          ID number of to do item. Assigned when added to list
   * description: Description of to do item
   * done:        True if to do item is complete
   */
  private Calendar cal = Calendar.getInstance();  
    
  private int id;               
  private String description;
  private Date date;
  private SimpleDateFormat format = new SimpleDateFormat("E M/d");
  private boolean done;
  
  /**
   * Constructor with done set to false in constructor
   * @param _id           ID number of to do item
   * @param _description  Description of to do item
   */
  public ToDoItem(int _id, String _description) {
    description = _description;
    id = _id;
    date = cal.getTime();
    done = false;     // Default to not completed
  }
 
  /**
   * Constructor with done set to false in constructor
   * @param _id           ID number of to do item
   * @param _description  Description of to do item
   * @param _date         The date a task must be done by
   */
  public ToDoItem(int _id, String _description, String _date) {
    description = _description;
    id = _id;
    date = calcDate(_date);
    done = false;     // Default to not completed
  }
  
    /**
   * Constructor
   * @param _id           ID number of to do item
   * @param _description  Description of to do item
   * @param _done         Done flag
   * @param _date         The date a task must be done by
   */
  public ToDoItem(int _id, String _description, boolean _done, String _date) {
    description = _description;
    id = _id;
    date = cal.getTime();
    done = _done;     // Default to not completed
  }

  /**
   * Constructor
   * @param _id           ID number of to do item
   * @param _description  Description of to do item
   * @param _done         Done flag
   */
  public ToDoItem(int _id, String _description, boolean _done) {
    description = _description;
    id = _id;
    date = cal.getTime();
    done = _done;     // Default to not completed
  }
     
  private Date calcDate(String _input)
  {
      Date tempDate = new Date(null);
      try {
          tempDate  = format.parse(_input);
      } catch (ParseException ex) 
      {
      }
      return tempDate ;
  }
  
  public String getDate()
  {
      return format.format(date);
  }
  
  public void setDate(Date date)
  {
      this.date = date;
  }
  
  public void setDate(String date)
  {
      this.date = calcDate(date);
  }
  
  /**
   * Get the to do item description
   * @return The description of to do item
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set the to do item description
   * @param description The value to be set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Get the done flag
   * @return The done flag
   */
  public boolean isDone() {
    return done;
  }

  /**
   * Set the done flag
   * @param done The value to be set
   */
  public void setDone(boolean done) {
    this.done = done;
  }
  
  /**
   * Toggles the done flag
   */
  public void toggleDone() {
    this.done = !this.done;
  }

  /**
   * Get the to do item ID
   * @return ID of the to do item
   */
  public int getId() {
    return id;
  }
  
  /**
   * Sets the ID of the to do item. Can only be called from inside this class
   * @param id ID value to set
   */
  public void setId(int id) {
    this.id = id;
  }
  
  /**
   * Transfer the description and done flag of another to do item into this one
   * @param anotherItem Item whose data values we are copying
   */
  public void merge(ToDoItem anotherItem) {
    this.setDescription(anotherItem.getDescription());
    this.setDone(anotherItem.isDone());    
  }

}
