package com.rc.saualnama.opros.manager;

import com.rc.saualnama.opros.Opros;
import com.rc.saualnama.opros.repository.OprosRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Bauyrzhan
 * Date: 4/10/13
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class OprosManagerImpl implements OprosManager {

    private OprosRepository oprosRepository;

    @Override
    public Opros getOprosById(long id) {

        Opros opros =  getOprosRepository().getOprosById(id);
        return opros;
    }

    public OprosRepository getOprosRepository() {
        return oprosRepository;
    }

    public void setOprosRepository(OprosRepository oprosRepository) {
        this.oprosRepository = oprosRepository;
    }
}
