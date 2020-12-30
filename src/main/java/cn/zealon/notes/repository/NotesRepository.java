package cn.zealon.notes.repository;

import cn.zealon.notes.domain.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 笔记
 * @author: zealon
 * @since: 2020/12/21
 */
@Repository
public class NotesRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Notes insert(Notes notes) {
        return this.mongoTemplate.insert(notes);
    }

    public void update(String id, Update update){
        Query query = Query.query(Criteria.where("_id").is(id));
        this.mongoTemplate.updateFirst(query, update, Notes.class);
    }

    public void remove(String id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        this.mongoTemplate.remove(query, "notes");
    }

    public void removeAll(String userId){
        Query query = Query.query(Criteria.where("user_id").is(userId));
        query.addCriteria(Criteria.where("delete").is(1));
        this.mongoTemplate.remove(query, "notes");
    }

    public Notes findOne(String id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        return this.mongoTemplate.findOne(query, Notes.class);
    }

    public List<Notes> findList(Query query){
        return this.mongoTemplate.find(query, Notes.class);
    }
}
