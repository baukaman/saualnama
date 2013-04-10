package com.rc.saualnama.opros.repository;

import com.rc.saualnama.opros.Opros;
import com.rc.saualnama.opros.OprosRaw;
import com.rc.saualnama.option.Option;
import com.rc.saualnama.question.Question;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Bauyrzhan
 * Date: 4/10/13
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class OprosRepositoryImpl implements OprosRepository {

    private JdbcTemplate jdbcTemplate;

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public Opros getOprosById(long id) {

        List<OprosRaw> list = new ArrayList<OprosRaw>();
        try{
            list = getJdbcTemplate().query("SELECT * from opros where oprosId=? order by oprosId, questionId, optionId",
                    getOprosRawMapperInstance(),id);
        }catch (Exception e){
            logger.error(e.toString());
        }

        List<Opros> ret = oprosRawToObject(list);

        if(ret.size()==0) return null;
        else return oprosRawToObject(list).get(0);
    }

    public List<Opros> oprosRawToObject(List<OprosRaw> list){

        Map<Long,Opros> map = new HashMap<Long,Opros>();

        for(OprosRaw oprosRaw:list){
            if(!map.containsKey(oprosRaw.getOprosId()))
                map.put(oprosRaw.getOprosId(),new Opros());
            Opros opros = map.get(oprosRaw.getOprosId());
            List<Question> questionList = opros.getQuestions();

            if(questionList.size()<oprosRaw.getQuestionId())
                questionList.add(new Question());

            Question q = questionList.get((int)oprosRaw.getQuestionId()-1);

            List<Option> options = q.getOptions();

            if(oprosRaw.getOptionId() == 1L){
                q.setText(oprosRaw.getText());
            }else{

                if(options.size() < oprosRaw.getOptionId()-1)
                    options.add(new Option());

                Option option = options.get((int)oprosRaw.getOptionId()-2);
                option.setText(oprosRaw.getText());
            }
        }

        List<Opros> ret = new ArrayList<Opros>();

        for(Map.Entry<Long,Opros> entry: map.entrySet()){
            Opros o = entry.getValue();
            ret.add(o);
        }

        return ret;
    }

    /*class UserMapper implements RowMapper<User> {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User(rs.getString(USER_EMAIL_FIELD), rs.getString(USER_FIRST_NAME_FIELD),
                        rs.getString(USER_LAST_NAME_FIELD), rs.getLong(USER_ID_FIELD), rs.getString(AVATAR_FIELD),
                        rs.getInt(ACCESS_LEVEL_FIELD), Language.valueOf(rs.getString(USER_LANGUAGE_FIELD)),
                        rs.getLong(USER_PARENT_ID_FIELD), UserStatus.getUserStatusByKey(rs.getInt(USER_STATUS_FIELD)));
                return user;
            }
        }*/
    class OprosRawMapper implements RowMapper<OprosRaw> {
        @Override
        public OprosRaw mapRow(ResultSet rs, int i) throws SQLException {
            OprosRaw oprosRaw = new OprosRaw();
            oprosRaw.setOprosId(rs.getLong("oprosId"));
            oprosRaw.setQuestionId(rs.getLong("questionId"));
            oprosRaw.setOptionId(rs.getLong("optionId"));
            oprosRaw.setOwnerName(rs.getString("ownerName"));
            oprosRaw.setText(rs.getString("text"));
            oprosRaw.setCount(rs.getLong("count"));
            return oprosRaw;
        }
    }

    private OprosRawMapper getOprosRawMapperInstance(){
        return new OprosRawMapper();
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
