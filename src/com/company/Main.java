package com.company;
//Jake Nelson exercise14 4-28-22
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String jsonData = "{ \"todos\": [ { \"body\": \"Walk the dog\", \"done\": false, \"id\": 0, \"priority\": 3, \"title\": \"dog\" }, { \"body\": \"Pay the bills\", \"done\": false, \"id\": 1, \"priority\": 1, \"title\": \"bills\" } ] }";
        Gson gson = new Gson();

        ToDoList toDoList = gson.fromJson(jsonData, ToDoList.class);
        System.out.println(toDoList.toString());

        ToDo item1 = new ToDo("Walk the dog", false, 0, 3, "dog");
        ToDo item2 = new ToDo("pay the bills", false, 1, 1, "bills");
        ToDoList toDoList1 = new ToDoList(new ToDo[]{item1, item2});
        try {
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(toDoList1, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

class ToDo{
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public ToDo(String body, boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = done;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ToDos{" +
                "body='" + body + '\'' +
                ", done=" + done +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}

class ToDoList{
    private ToDo[] todos;

    public ToDoList(ToDo[] todos) {
        this.todos = todos;
    }

    public ToDo[] getTodos() {
        return todos;
    }

    public void setTodos(ToDo todo) {
        this.todos = todos;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "todos=" + Arrays.toString(todos) +
                '}';
    }
}