package imageplustodataset;

import ij.IJ;
import ij.ImagePlus;
import ij.gui.NewImage;
import net.imagej.Dataset;
import net.imagej.ImageJ;
import net.imagej.ImgPlus;
import net.imagej.patcher.LegacyInjector;
import net.imglib2.img.display.imagej.ImageJFunctions;

public class ImagePlusToDataset {


    static {
        LegacyInjector.preinit();
    }

    public static void main(String... args) {

        // init first instance of ImageJ
        new ImageJ();

        // init second instance ; the second instance apparently has no legacyService.getIJ1Helper()
        ImageJ ij = new ImageJ();


        ImagePlus imp = NewImage.createShortImage("hello world", 100, 100, 10, NewImage.FILL_RAMP);

        Dataset dataSet = ij.dataset().create(new ImgPlus(ImageJFunctions.wrap(imp)));

        ij.ui().show(dataSet);


    }
}
