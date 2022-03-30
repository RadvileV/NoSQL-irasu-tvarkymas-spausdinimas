package com.company;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;

public class CharacterDAO {

    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    static MongoCollection<Document> collection;

    public CharacterDAO() {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        mongoDatabase = mongoClient.getDatabase("db");
        collection = mongoDatabase.getCollection("chars");
    }

    //1.1, 1.2
    public void insert(Character character) {
        Document document = new Document();
        String jsonString = objectToJason(character);
        document = Document.parse(jsonString);
        try {
            collection.insertOne(document);
            System.out.println("Pavyko sukurti įrašą");
        } catch (MongoWriteException m) {
            m.printStackTrace();
            System.out.println("Nepavyko sukurti įrašo");
        }
    }

    //1.3
    public void update (Character character) {
        Document document = collection.find(Filters.eq("charId", character.getCharId())).first();
        try {
            collection.updateOne(new Document("_id", document.get("_id")),
                    new Document("$set", new Document("charId", character.getCharId())
                            .append("name", character.getName())
                            .append("type", character.getType())
                            .append("address", character.getAddress())
                            .append("work", character.getWork())
                            .append("salary", character.getSalary())
                    ));
            System.out.println("Įrašas atnaujintas sėkmingai");
        } catch (MongoWriteException m) {
            m.printStackTrace();
            System.out.println("Įrašo atnaujinti nepavyko");
        }
    }

    //1.4
    public void printAll(){
        FindIterable<Document> iterDoc = collection.find();
        Iterator iterator = iterDoc.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //1.5
    public static Character searchByName(String by) {
        Document document = collection.find(Filters.eq("name", by)).first();
        ObjectMapper objectMapper = new ObjectMapper();
        Character character = null;
        try {
            character = objectMapper.readValue(document.toJson(), Character.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return character;
    }

    //1.6
    public void printLowerSalary(double salary){
        FindIterable<Document> iterDoc = collection.find(Filters.lt("salary", salary));
        Iterator iter = iterDoc.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    //1.7
    public void delete(int id) {
        Document document = collection.findOneAndDelete(Filters.eq("charId", id));
    }

    //1.8
    public void deleteWhatsLeft(){
        FindIterable<Document> findIterable = collection.find();
        for (Document document : findIterable) {
            collection.deleteMany(document);
        }
    }

    public String objectToJason(Character character) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(character);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
