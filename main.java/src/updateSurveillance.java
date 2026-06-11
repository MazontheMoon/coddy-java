import java.util.Arrays;

class UpdateSurveillance {
    public static int[] updateSurveillance(int[] cameras, int startIndex, int endIndex, int cameraToCheck) {
        int initialActiveCount = countActiveCameras(cameras);
        
        for (int i = startIndex; i <= endIndex; i++) {
            cameras[i] = 1;
        }
        
        int updatedActiveCount = countActiveCameras(cameras);
        
        int cameraStatus = cameras[cameraToCheck];
        
        return new int[]{initialActiveCount, updatedActiveCount, cameraStatus};
    }
    
    private static int countActiveCameras(int[] cameras) {
        return (int) Arrays.stream(cameras).filter(camera -> camera == 1).count();
    }
}