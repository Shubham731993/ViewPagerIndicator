package travel.com.test;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by shubham.srivastava on 05/04/18.
 */

public class SlidesAdapter extends PagerAdapter {

  Context context;

  public SlidesAdapter(Context context) {
    this.context = context;
  }

  public SlidesAdapter() {
  }

  public String[] slide_headings = {
      "Connectez-vous",
      "Gérez vos tâches rapidement",
      "Suivez vos progrés facilement",
      "Accéder aux services de votre université"
  };

  public String[] slide_descriptions = {
      "à \"app name\"",
      "Organisez votre travail et vos études et controlez les\n" +
          "grâce à un agenda facile à utiliser",
      "Enregistrer les notes de matières et suivez vos progrés",
      "Découvrez les clubs, bibliothéques et les services de votre université"
  };

  @Override
  public int getCount() {
    return slide_headings.length;
  }

  @Override
  public boolean isViewFromObject(View view, Object obj) {
    return view == obj;
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

    TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
    TextView slideDescription = (TextView) view.findViewById(R.id.slide_description);

    slideHeading.setText(slide_headings[position]);
    slideDescription.setText(slide_descriptions[position]);

    ViewPager vp = (ViewPager) container;
    container.addView(view, 0);

    return view;
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    ViewPager vp = (ViewPager) container;
    View view = (View) object;
    vp.removeView(view);
  }
}
