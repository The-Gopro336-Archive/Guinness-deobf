package org.spongepowered.asm.mixin.injection.invoke;

import com.google.common.collect.ObjectArrays;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.mixin.injection.struct.Target;

static class RedirectedInvoke
{
    final Target target;
    final MethodInsnNode node;
    final Type returnType;
    final Type[] args;
    final Type[] locals;
    boolean captureTargetArgs;
    
    RedirectedInvoke(final Target target, final MethodInsnNode node) {
        this.captureTargetArgs = false;
        this.target = target;
        this.node = node;
        this.returnType = Type.getReturnType(node.desc);
        this.args = Type.getArgumentTypes(node.desc);
        this.locals = ((node.getOpcode() == 184) ? this.args : ObjectArrays.concat(Type.getType("L" + node.owner + ";"), this.args));
    }
}
