package org.newdawn.slick.particles;

static final class ParticleIO$1 implements ConfigurableEmitterFactory {
    @Override
    public ConfigurableEmitter createEmitter(final String name) {
        return new ConfigurableEmitter(name);
    }
}