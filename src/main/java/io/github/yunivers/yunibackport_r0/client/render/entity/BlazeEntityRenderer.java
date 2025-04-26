package io.github.yunivers.yunibackport_r0.client.render.entity;

import io.github.yunivers.yunibackport_r0.client.render.entity.model.BlazeEntityModel;
import net.minecraft.client.render.entity.LivingEntityRenderer;

public class BlazeEntityRenderer extends LivingEntityRenderer
{
    public BlazeEntityRenderer()
    {
        super(new BlazeEntityModel(), 0.5f);
    }
}
