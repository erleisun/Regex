package View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myjava.R;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.concurrent.ThreadPoolExecutor;

public class CarView extends View {
    private Bitmap mCarBitmap;
    private Path path;
    private PathMeasure pathMeasure;//路径计算
    private float distanceRatio = 0;
    private Paint circlePaint;//画圆的画笔
    private Paint carPaint;//小车画笔
    private Matrix carMatrix;//针对小车图片操作的矩阵


    public CarView(Context context) {
        super(context);
    }

    public CarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context){
        Reader reader ;
        System.arraycopy();
        mCarBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher_background);
        path = new Path();
        path.addCircle(0,0,200,Path.Direction.CW);
        pathMeasure = new PathMeasure(path,false);
        circlePaint = new Paint();
        circlePaint.setStrokeWidth(5);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.BLACK);

        carPaint = new Paint();
        carPaint.setStrokeWidth(5);
        carPaint.setStyle(Paint.Style.STROKE);
        carPaint.setColor(Color.DKGRAY);

        carMatrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        //移动canvas坐标到中心
        canvas.translate(width/2,height/2);
        carMatrix.reset();
        distanceRatio += 0.06;//进度累加
        if(distanceRatio >=0){
            distanceRatio = 0;
        }
        float distance = pathMeasure.getLength()*distanceRatio;
        float[] pos = new float[2];
        float[] tan = new float[2];

        float degree = (float) Math.atan2(tan[1],tan[0]*180/Math.PI);
        //设置旋转角度
        carMatrix.postRotate(degree,mCarBitmap.getWidth()/2,mCarBitmap.getHeight()/2);
        carMatrix.postTranslate(pos[0]-mCarBitmap.getWidth()/2,pos[1]-mCarBitmap.getHeight());
        //画圆环
        canvas.drawPath(path,circlePaint);
        //画小车
        canvas.drawBitmap(mCarBitmap,carMatrix,carPaint);
        invalidate();//不停重绘制
    }

    String
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
