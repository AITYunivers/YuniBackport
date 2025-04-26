package io.github.yunivers.yunibackport_r0.structure;

import io.github.yunivers.yunibackport_r0.util.WeightedRandomChoice;

public class StructurePieceTreasure extends WeightedRandomChoice
{
    public int field_35596_a;
    public int field_35594_b;
    public int field_35595_c;
    public int field_35593_e;

    public StructurePieceTreasure(int n, int n2, int n3, int n4, int weight) {
        super(weight);
        this.field_35596_a = n;
        this.field_35594_b = n2;
        this.field_35595_c = n3;
        this.field_35593_e = n4;
    }
}
