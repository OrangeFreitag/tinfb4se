package de.codecrunch;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.utils.UBJsonReader;

public class Model3DFactory {
    public static Model empty,end,occupied,path_straight,path_left,path_right,path_cross,path_split_right,path_split_left;

    private Model3DFactory(){}

    public static void setup(){
        UBJsonReader jsonReader = new UBJsonReader();
        G3dModelLoader modelLoader = new G3dModelLoader(jsonReader);

        empty = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/empty.g3db", Files.FileType.Internal));
        end = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/end.g3db", Files.FileType.Internal));
        occupied = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/occupied.g3db", Files.FileType.Internal));
        path_straight = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/path_straight.g3db", Files.FileType.Internal));
        path_left = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/path_left.g3db", Files.FileType.Internal));
        path_right = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/path_right.g3db", Files.FileType.Internal));
        path_cross = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/path_cross.g3db", Files.FileType.Internal));
        path_split_right = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/path_split_right.g3db", Files.FileType.Internal));
        path_split_left = modelLoader.loadModel(Gdx.files.getFileHandle("tiles/models/path_split_left.g3db", Files.FileType.Internal));
    }

    public static ModelInstance instantiate(Model model) {
        ModelInstance instance = new ModelInstance(model);
        return instance;
    }
}