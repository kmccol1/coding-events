package org.launchcode.codingevents.data;
import org.launchcode.codingevents.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepositoryDAO extends CrudRepository<Event, Integer>
{

}
