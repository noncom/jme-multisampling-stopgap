 
package org.shaderblowex.filter.MultiSamplingFix;

import com.jme3.asset.AssetManager;
import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;
import com.jme3.material.Material;
import com.jme3.post.Filter;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;

import java.io.IOException;


public class MultiSamplingFix extends Filter {

    public MultiSamplingFix( )
    {
         super("MultiSamplingFix");
    }

    @Override
    protected void initFilter(AssetManager manager, RenderManager renderManager, ViewPort vp, int w, int h) {
        material = new Material(manager, "ShaderBlowEx/MatDefs/MultiSamplingFix/MultiSamplingFix.j3md");
    }

    @Override
    protected boolean isRequiresDepthTexture() {
        return false;
    }

    @Override
    protected Material getMaterial() {
        return material;
    }

    public void write(JmeExporter ex) throws IOException {
        super.write(ex);
        OutputCapsule oc = ex.getCapsule(this);
    }

    @Override
    public void read(JmeImporter im) throws IOException {
        super.read(im);
        InputCapsule ic = im.getCapsule(this);
        
    }
private   void checkFloatArgument(float value, float min, float max, String name) {
if (value < min || value > max) {
throw new IllegalArgumentException(name + " was " + value + " but should be between " + min + " and " + max);
}
}
private   void checkIntArgument(int value, int min, int max, String name) {
if (value < min || value > max) {
throw new IllegalArgumentException(name + " was " + value + " but should be between " + min + " and " + max);
}
}
}