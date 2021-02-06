import com.mongodb.MongoClient
import com.mongodb.MongoCredential
import com.mongodb.client.FindIterable
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import org.bson.Document

fun main() {
    //creating a Mongo client
    var mongo:MongoClient = MongoClient("localhost",27017)

    //creating credential
    var credential = MongoCredential.createCredential("Shubham","employees","shubh@123".toCharArray())

    println("Connected to the database successfully")

    //Accessing or creating the database
    var database:MongoDatabase= mongo.getDatabase("Users")

    //creating a collection/table
    database.createCollection("userDetails")
    println("collection created successfully")

    //retrieving a collection
    var collection:MongoCollection<Document> = database.getCollection("userDetails")
    println("Retrieved collection successfully")

    //creating a document and inserting few key-value pairs in it
    var document:Document= Document("title","MongoDB")
        .append("name","Aman")
        .append("age","25")
        .append("subject","physics")

    //inserting the document/row in collection/table
    collection.insertOne(document)
    println("document inserted successfully")

    //To insert multiple documents/rows in collection/table
    var document1:Document= Document()
        .append("name","Chaman")
        .append("age","27")
        .append("subject","history")

    var document2:Document= Document()
        .append("name","Naman")
        .append("age","28")
        .append("subject","Math")

    var documents: ArrayList<Document> = ArrayList()
    documents.add(document1)
    documents.add(document2)

    collection.insertMany(documents)
    println("multiple documents inserted successfully")
//
//    //To fetch all the documents
//    var iterDoc:FindIterable<Document> = collection.find()
//    var it:Iterator<Document> = iterDoc.iterator()
//
//    var i:Int = 1
//    while (it.hasNext()){
//        println(it.next())
//        i++
//    }

    //To update the document
//    collection.updateMany(Filters.eq("name","Baman"),Updates.set("age","35"))
//    println("document updated successfully")

//    var iterDoc:FindIterable<Document> = collection.find()
//    var it:Iterator<Document> = iterDoc.iterator()
//
//    var i:Int = 1
//    while (it.hasNext()){
//        println(it.next())
//        i++
//    }

//    collection.deleteMany(Filters.eq("name","Aman"))
//    println("object deleted successfully")

    //To drop a collection which was fetched previously
//    collection.drop()
//    println("collection which was fetched previously has been dropped")

    //To drop a database which was fetched previously
   // database.drop()

    for (fetchedCollection in database.listCollectionNames()){
        println(fetchedCollection)
    }

}