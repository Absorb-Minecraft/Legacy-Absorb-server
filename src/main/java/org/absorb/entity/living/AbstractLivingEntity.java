package org.absorb.entity.living;

import org.absorb.entity.AbstractEntity;
import org.absorb.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public class AbstractLivingEntity extends AbstractEntity implements LivingEntity {

    public AbstractLivingEntity(@NotNull EntityType type) {
        super(type);
    }
}
