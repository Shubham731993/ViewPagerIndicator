package travel.com.test;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by shubham.srivastava on 06/11/17.
 */

public class MainActivity extends AppCompatActivity {


  private ViewPager viewPager;
  private SlidesAdapter slidesAdapter;
  private LinearLayout dotsLayout;
  private TextView[] dots;
  private int[] layouts;
  private Button btnLogin, btnJoin;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    viewPager =  findViewById(R.id.view_pager);
    dotsLayout = findViewById(R.id.layoutDots);
    btnLogin = findViewById(R.id.btn_login);
    btnJoin = findViewById(R.id.btn_join);

    slidesAdapter = new SlidesAdapter(this);
    viewPager.setAdapter(slidesAdapter);

   // addBottomDots(0);

    CirclePageIndicator mPageIndicator = (CirclePageIndicator) findViewById(R.id.circle_page_indicator);
    mPageIndicator.setViewPager(viewPager);

    viewPager.addOnPageChangeListener(viewListener);

  }




  private void addBottomDots(int position) {

    dots = new TextView[4];

    for (int i = 0; i < dots.length; i++) {
      dots[i] = new TextView(this);
      dots[i].setText(Html.fromHtml("&#8226;"));
      dots[i].setTextSize(35);
      dots[i].setTextColor(getResources().getColor(R.color.dot_inactive));
      dotsLayout.addView(dots[i]);
    }

    if(dots.length>0){
      dots[position].setTextColor(getResources().getColor(R.color.dot_active));
    }
  }

  ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
  };

}
