package com.charity_hub.shared.domain.model;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class should be used to describe any entity domain class (DDD)
 * Entities should have id that identify it, this id should be a value object
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * public class UserId implements ValueObject {
 *     private final UUID id;
 *
 *     public UserId(UUID id) {
 *         this.id = id;
 *     }
 * }
 *
 * public class User extends Entity<UserId> {
 *     public User(UserId id) {
 *         super(id);
 *     }
 *     // some code
 * }
 * }
 * </pre>
 */
@Getter
public abstract class Entity<T extends ValueObject> implements DomainModel {
    protected final Logger log;
    private final T id;

    protected Entity(T id) {
        this.id = id;
        this.log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Entity<?> otherEntity = (Entity<?>) obj;
        return this.id.equals(otherEntity.getId());
    }
}