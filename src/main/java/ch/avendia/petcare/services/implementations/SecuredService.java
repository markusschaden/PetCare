package ch.avendia.petcare.services.implementations;

import ch.avendia.petcare.entities.Client;
import ch.avendia.petcare.entities.DatabaseEntity;
import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.entities.transfer.BasicRequestDTO;
import ch.avendia.petcare.framework.exception.NoSessionException;

/**
 * Created by Markus on 17.04.2015.
 */
public abstract class SecuredService extends BasicService {

    @Override
    public void check(BasicRequestDTO<? extends DatabaseEntity> dto) {
        super.check(dto);

        if(session == null || session.getAccount() == null) {
            throw new NoSessionException();
        }

    }



}
