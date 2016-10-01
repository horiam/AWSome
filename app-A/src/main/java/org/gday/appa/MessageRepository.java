package org.gday.appa;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, String> {

    // TODO save must make sure there is not another message with the same id in the repo
}
