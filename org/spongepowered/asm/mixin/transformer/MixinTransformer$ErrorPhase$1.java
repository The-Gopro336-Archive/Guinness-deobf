package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.mixin.extensibility.IMixinErrorHandler;

enum MixinTransformer$ErrorPhase$1
{
    @Override
    IMixinErrorHandler.ErrorAction onError(final IMixinErrorHandler handler, final String context, final InvalidMixinException ex, final IMixinInfo mixin, final IMixinErrorHandler.ErrorAction action) {
        try {
            return handler.onPrepareError(mixin.getConfig(), ex, mixin, action);
        }
        catch (AbstractMethodError ame) {
            return action;
        }
    }
    
    @Override
    protected String getContext(final IMixinInfo mixin, final String context) {
        return String.format("preparing %s in %s", mixin.getName(), context);
    }
}