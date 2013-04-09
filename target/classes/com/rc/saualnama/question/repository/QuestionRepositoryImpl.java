package com.rc.saualnama.question.repository;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: Bauka
 * Date: 4/8/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuestionRepositoryImpl implements QuestionRepository {
    private JdbcTemplate jdbcTemplate;

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public Long createNewQuestion(final String text) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        Long questionId = null;
        try{
          jdbcTemplate.update(new PreparedStatementCreator() {
              @Override
              public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                  PreparedStatement st = connection.prepareStatement("INSERT INTO QUESTIONS(text) values (?)",
                          Statement.RETURN_GENERATED_KEYS);
                  st.setString(1,text);
                  return st;
              }
          },keyHolder);
          questionId = keyHolder.getKey().longValue();
        }catch (Exception e){
            logger.info(e.toString());
        }
        return questionId;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
