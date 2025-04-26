package io.github.yunivers.yunibackport_r0.client.render.entity.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class BlazeEntityModel extends EntityModel
{
    private ModelPart[] penises = new ModelPart[12];
    private ModelPart head;

    public BlazeEntityModel()
    {
        for (int i = 0; i < this.penises.length; ++i)
        {
            this.penises[i] = new ModelPart(0, 16);
            this.penises[i].addCuboid(0.0f, 0.0f, 0.0f, 2, 8, 2);
        }
        this.head = new ModelPart(0, 0);
        this.head.addCuboid(-4.0f, -4.0f, -4.0f, 8, 8, 8);
    }

    @Override
    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale)
    {
        this.setAngles(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
        this.head.render(scale);
        for (ModelPart modelPart : this.penises)
            modelPart.render(scale);
    }

    @Override
    public void setAngles(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale)
    {
        int n;
        float f7 = animationProgress * (float)Math.PI * -0.1f;
        for (n = 0; n < 4; ++n)
        {
            this.penises[n].pivotY = -2.0f + MathHelper.cos(((float)(n * 2) + animationProgress) * 0.25f);
            this.penises[n].pivotX = MathHelper.cos(f7) * 9.0f;
            this.penises[n].pivotZ = MathHelper.sin(f7) * 9.0f;
            f7 += 1.5707964f;
        }
        f7 = 0.7853982f + animationProgress * (float)Math.PI * 0.03f;
        for (n = 4; n < 8; ++n)
        {
            this.penises[n].pivotY = 2.0f + MathHelper.cos(((float)(n * 2) + animationProgress) * 0.25f);
            this.penises[n].pivotX = MathHelper.cos(f7) * 7.0f;
            this.penises[n].pivotZ = MathHelper.sin(f7) * 7.0f;
            f7 += 1.5707964f;
        }
        f7 = 0.47123894f + animationProgress * (float)Math.PI * -0.05f;
        for (n = 8; n < 12; ++n)
        {
            this.penises[n].pivotY = 11.0f + MathHelper.cos(((float)n * 1.5f + animationProgress) * 0.5f);
            this.penises[n].pivotX = MathHelper.cos(f7) * 5.0f;
            this.penises[n].pivotZ = MathHelper.sin(f7) * 5.0f;
            f7 += 1.5707964f;
        }
        this.head.yaw = headYaw / 57.295776f;
        this.head.pitch = headPitch / 57.295776f;
    }
}
