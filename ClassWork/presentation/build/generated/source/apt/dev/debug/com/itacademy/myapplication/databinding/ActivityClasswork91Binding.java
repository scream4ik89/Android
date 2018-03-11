package com.itacademy.myapplication.databinding;
import com.itacademy.myapplication.R;
import com.itacademy.myapplication.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityClasswork91Binding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.Button mboundView3;
    @NonNull
    public final android.widget.TextView textViewBinding;
    @NonNull
    public final android.widget.TextView textViewBinding3;
    // variables
    @Nullable
    private com.itacademy.myapplication.classwork9.MyEntitty mMyEntity;
    // values
    // listeners
    private OnClickListenerImpl mMyEntityButtonClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityClasswork91Binding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.Button) bindings[3];
        this.mboundView3.setTag(null);
        this.textViewBinding = (android.widget.TextView) bindings[1];
        this.textViewBinding.setTag(null);
        this.textViewBinding3 = (android.widget.TextView) bindings[2];
        this.textViewBinding3.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.myEntity == variableId) {
            setMyEntity((com.itacademy.myapplication.classwork9.MyEntitty) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMyEntity(@Nullable com.itacademy.myapplication.classwork9.MyEntitty MyEntity) {
        this.mMyEntity = MyEntity;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.myEntity);
        super.requestRebind();
    }
    @Nullable
    public com.itacademy.myapplication.classwork9.MyEntitty getMyEntity() {
        return mMyEntity;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeMyEntityText((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeMyEntityTextButton((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeMyEntityButtonVisible((android.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMyEntityText(android.databinding.ObservableField<java.lang.String> MyEntityText, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMyEntityTextButton(android.databinding.ObservableField<java.lang.String> MyEntityTextButton, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMyEntityButtonVisible(android.databinding.ObservableBoolean MyEntityButtonVisible, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        android.view.View.OnClickListener myEntityButtonClickAndroidViewViewOnClickListener = null;
        int myEntityButtonVisibleViewVISIBLEViewGONE = 0;
        java.lang.String myEntityTextGet = null;
        android.databinding.ObservableField<java.lang.String> myEntityText = null;
        int myEntityButtonVisibleViewGONEViewVISIBLE = 0;
        boolean myEntityButtonVisibleGet = false;
        com.itacademy.myapplication.classwork9.MyEntitty myEntity = mMyEntity;
        android.databinding.ObservableField<java.lang.String> myEntityTextButton = null;
        java.lang.String myEntityTextButtonGet = null;
        android.databinding.ObservableBoolean myEntityButtonVisible = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x18L) != 0) {

                    if (myEntity != null) {
                        // read myEntity::buttonClick
                        myEntityButtonClickAndroidViewViewOnClickListener = (((mMyEntityButtonClickAndroidViewViewOnClickListener == null) ? (mMyEntityButtonClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mMyEntityButtonClickAndroidViewViewOnClickListener).setValue(myEntity));
                    }
            }
            if ((dirtyFlags & 0x19L) != 0) {

                    if (myEntity != null) {
                        // read myEntity.text
                        myEntityText = myEntity.text;
                    }
                    updateRegistration(0, myEntityText);


                    if (myEntityText != null) {
                        // read myEntity.text.get()
                        myEntityTextGet = myEntityText.get();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (myEntity != null) {
                        // read myEntity.textButton
                        myEntityTextButton = myEntity.textButton;
                    }
                    updateRegistration(1, myEntityTextButton);


                    if (myEntityTextButton != null) {
                        // read myEntity.textButton.get()
                        myEntityTextButtonGet = myEntityTextButton.get();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (myEntity != null) {
                        // read myEntity.buttonVisible
                        myEntityButtonVisible = myEntity.buttonVisible;
                    }
                    updateRegistration(2, myEntityButtonVisible);


                    if (myEntityButtonVisible != null) {
                        // read myEntity.buttonVisible.get()
                        myEntityButtonVisibleGet = myEntityButtonVisible.get();
                    }
                if((dirtyFlags & 0x1cL) != 0) {
                    if(myEntityButtonVisibleGet) {
                            dirtyFlags |= 0x40L;
                            dirtyFlags |= 0x100L;
                    }
                    else {
                            dirtyFlags |= 0x20L;
                            dirtyFlags |= 0x80L;
                    }
                }


                    // read myEntity.buttonVisible.get() ? View.VISIBLE : View.GONE
                    myEntityButtonVisibleViewVISIBLEViewGONE = ((myEntityButtonVisibleGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                    // read myEntity.buttonVisible.get() ? View.GONE : View.VISIBLE
                    myEntityButtonVisibleViewGONEViewVISIBLE = ((myEntityButtonVisibleGet) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, myEntityTextButtonGet);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            this.mboundView3.setOnClickListener(myEntityButtonClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.textViewBinding, myEntityTextGet);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            this.textViewBinding.setVisibility(myEntityButtonVisibleViewVISIBLEViewGONE);
            this.textViewBinding3.setVisibility(myEntityButtonVisibleViewGONEViewVISIBLE);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.itacademy.myapplication.classwork9.MyEntitty value;
        public OnClickListenerImpl setValue(com.itacademy.myapplication.classwork9.MyEntitty value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.buttonClick(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityClasswork91Binding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityClasswork91Binding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityClasswork91Binding>inflate(inflater, com.itacademy.myapplication.R.layout.activity_classwork9_1, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityClasswork91Binding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityClasswork91Binding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.itacademy.myapplication.R.layout.activity_classwork9_1, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityClasswork91Binding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityClasswork91Binding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_classwork9_1_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityClasswork91Binding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): myEntity.text
        flag 1 (0x2L): myEntity.textButton
        flag 2 (0x3L): myEntity.buttonVisible
        flag 3 (0x4L): myEntity
        flag 4 (0x5L): null
        flag 5 (0x6L): myEntity.buttonVisible.get() ? View.VISIBLE : View.GONE
        flag 6 (0x7L): myEntity.buttonVisible.get() ? View.VISIBLE : View.GONE
        flag 7 (0x8L): myEntity.buttonVisible.get() ? View.GONE : View.VISIBLE
        flag 8 (0x9L): myEntity.buttonVisible.get() ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}