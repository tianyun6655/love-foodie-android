package untils;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;

/**
 * Created by tianyun chen on 2016/10/9.
 */
public class AnimationUtils {
    public static ObjectAnimator tada(View view, float shakeFactor) {
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofKeyframe(View.SCALE_X,

                Keyframe.ofFloat(0f, 1f),

                Keyframe.ofFloat(.1f, .9f),

                Keyframe.ofFloat(.2f, .9f),

                Keyframe.ofFloat(.3f, 1.1f),

                Keyframe.ofFloat(.4f, 1.1f),

                Keyframe.ofFloat(.5f, 1.1f),

                Keyframe.ofFloat(.6f, 1.1f),

                Keyframe.ofFloat(.7f, 1.1f),

                Keyframe.ofFloat(.8f, 1.1f),

                Keyframe.ofFloat(.9f, 1.1f),

                Keyframe.ofFloat(1f, 1f)

        );
        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofKeyframe(View.SCALE_Y,

                Keyframe.ofFloat(0f, 1f),

                Keyframe.ofFloat(.1f, .9f),

                Keyframe.ofFloat(.2f, .9f),

                Keyframe.ofFloat(.3f, 1.1f),

                Keyframe.ofFloat(.4f, 1.1f),

                Keyframe.ofFloat(.5f, 1.1f),

                Keyframe.ofFloat(.6f, 1.1f),

                Keyframe.ofFloat(.7f, 1.1f),

                Keyframe.ofFloat(.8f, 1.1f),

                Keyframe.ofFloat(.9f, 1.1f),

                Keyframe.ofFloat(1f, 1f)

        );
        PropertyValuesHolder pvhRotate = PropertyValuesHolder.ofKeyframe(View.ROTATION,

                Keyframe.ofFloat(0f, 0f),

                Keyframe.ofFloat(.1f, -3f * shakeFactor),

                Keyframe.ofFloat(.2f, -3f * shakeFactor),

                Keyframe.ofFloat(.3f, 3f * shakeFactor),

                Keyframe.ofFloat(.4f, -3f * shakeFactor),

                Keyframe.ofFloat(.5f, 3f * shakeFactor),

                Keyframe.ofFloat(.6f, -3f * shakeFactor),

                Keyframe.ofFloat(.7f, 3f * shakeFactor),

                Keyframe.ofFloat(.8f, -3f * shakeFactor),

                Keyframe.ofFloat(.9f, 3f * shakeFactor),

                Keyframe.ofFloat(1f, 0)

        );
        return ObjectAnimator.ofPropertyValuesHolder(view, pvhScaleX, pvhScaleY, pvhRotate).

                setDuration(1000);

    }

    public static void open_Menu(View layout_view, final View sub1, final View sub2, final View sub3){
        layout_view.setVisibility(View.VISIBLE);
        Log.d("animation",layout_view.getHeight()+"");

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(layout_view,"translationY",0f,84f).setDuration(500);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator tada = AnimationUtils.tada(sub1,1f);
                tada.start();
                ObjectAnimator tada2 = AnimationUtils.tada(sub2,1f);
                tada2.start();
                ObjectAnimator tada3 =AnimationUtils.tada(sub3,1f);
                tada3.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
         objectAnimator.start();
    }

    public  static void ratationMenuIcon(View view,int duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",0f,90f).setDuration(duration);
        animator.start();
    }
    public  static void ratationMenuIcon2(View view,int duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",90f,0f).setDuration(duration);
        animator.start();
    }


    public static  void close_menu(final View view){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,"translationY",84f,0).setDuration(500);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                        view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.start();

    }

}
