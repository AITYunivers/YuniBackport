package io.github.yunivers.yunibackport_r0.structure.fortress;

@SuppressWarnings("rawtypes")
public class NetherFortressStructurePieceWeight
{
    public Class field_40699_a;
    public final int field_40697_b;
    public int field_40698_c;
    public int field_40695_d;
    public boolean field_40696_e;

    public NetherFortressStructurePieceWeight(Class clazz, int n, int n2, boolean bl)
    {
        this.field_40699_a = clazz;
        this.field_40697_b = n;
        this.field_40695_d = n2;
        this.field_40696_e = bl;
    }

    public NetherFortressStructurePieceWeight(Class clazz, int n, int n2)
    {
        this(clazz, n, n2, false);
    }

    public boolean func_40693_a(int n)
    {
        return this.field_40695_d == 0 || this.field_40698_c < this.field_40695_d;
    }

    public boolean func_40694_a()
    {
        return this.field_40695_d == 0 || this.field_40698_c < this.field_40695_d;
    }
}
