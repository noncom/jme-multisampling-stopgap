#extension GL_ARB_texture_multisample : enable
#import "Common/ShaderLib/GLSLCompat.glsllib"

varying vec2 texCoord;

#ifdef NUM_SAMPLES

uniform sampler2DMS m_Texture;

vec4 DoMagic() {
    ivec2 iTexC = ivec2(texCoord * vec2(textureSize(m_Texture)));
    vec4 color = vec4(0.0);

    for (int i = 0; i < NUM_SAMPLES; i++) {
        vec4 c = texelFetch(m_Texture, iTexC, i);
        color += c;
    }

    color /= float(NUM_SAMPLES);

    return color;
}
#else

uniform sampler2D m_Texture;

vec4 DoMagic() {
    return texture2D(m_Texture, texCoord);
}
#endif

void main() {
    gl_FragColor = DoMagic();
}