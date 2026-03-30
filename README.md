{
  "project_meta": {
    "title": "TomatoScan",
    "subtitle": "Mobile Tomato Disease Detection using CNN & ML",
    "emoji": "🍅",
    "color_from": "#1a4a0e",
    "color_to": "#3d8c33",
    "sdk": "gradio",
    "sdk_version": "4.0",
    "python_version": "3.10",
    "entry_point": "app.py",
    "pinned": false
  },
  "overview": {
    "description": "TomatoScan is an end-to-end plant pathology system that classifies 10 categories of tomato leaf conditions from a photograph, including 9 distinct diseases and 1 healthy class.",
    "high_level_summary": "Deep learning pipeline benchmarking InceptionV3, VGG16, ResNet50, and a custom CNN using transfer learning on the PlantVillage tomato dataset. Best model achieves 94.0% test accuracy and is exported as TFLite for on-device Android inference."
  },
  "problem": {
    "business_problem": "Tomato crop diseases cause significant yield losses for smallholder farmers, especially in remote areas with no access to agronomists or stable internet connectivity.",
    "problem_statement": "How can we accurately classify tomato leaf diseases from a smartphone photo in real-time, fully offline, to enable early intervention and minimize crop loss?"
  },
  "goals": {
    "primary": "Train a high-accuracy deep learning model (>90%) for 10-class tomato disease classification and deploy it on Android as a TFLite model for offline inference.",
    "secondary": "Compare transfer learning (InceptionV3, VGG16, ResNet50) against ensemble stacking approaches (RF, KNN, SVM, NB, DT, Logistic Regression) to identify the best strategy for mobile deployment."
  },
  "objectives": [
    "Benchmark InceptionV3, VGG16, ResNet50, and custom CNN on the TomatoLeaf dataset",
    "Implement ensemble stacking with CNN feature extractors and ML classifiers",
    "Export best-performing model to TFLite format for Android deployment",
    "Build an Android app (Jetpack Compose + CameraX) with real-time on-device inference",
    "Achieve ≥90% macro F1-score on the 10-class test set"
  ],
  "dataset": {
    "name": "TomatoLeaf (PlantVillage subset)",
    "size": "11,000 images across 10 classes (8,000 train / 2,000 val / 1,000 test)",
    "description": "RGB images of tomato leaves representing 9 disease conditions and 1 healthy class, sourced from the PlantVillage dataset via Kaggle. Each class contains 100 balanced test samples.",
    "features": "RGB images resized to 128×128, normalized to [0,1]. Labels inferred from directory structure. No manual feature engineering — raw pixel values fed into pretrained CNN backbones.",
    "source": "https://www.kaggle.com/datasets/ashishmotwani/tomato"
  },
  "methodology": {
    "preprocessing": {
      "data_cleaning": "No explicit cleaning required — dataset is pre-curated from PlantVillage. Directory-based label inference via tf.keras.preprocessing.image_dataset_from_directory.",
      "feature_engineering": "None for deep learning models. For ensemble stacking, CNN penultimate layer activations used as feature vectors (Global Average Pooling output).",
      "encoding": "Categorical one-hot encoding for deep learning (label_mode='categorical'). Integer encoding for sklearn ML classifiers.",
      "scaling": "Pixel normalization via tf.keras.layers.Rescaling(1./255) applied to all splits.",
      "balancing": "Dataset is inherently balanced — 100 test samples per class. Train/val split uses stratified sampling via seed=123."
    },
    "feature_selection": "Not applicable for end-to-end deep learning. For ensemble stacking, features extracted from the GlobalAveragePooling2D layer of pretrained backbones (InceptionV3 or VGG16), producing 2048-dim or 512-dim vectors respectively.",
    "model": {
      "algorithm": "Phase 1 — Transfer Learning: InceptionV3, VGG16, ResNet50 with ImageNet weights, GlobalAveragePooling2D, Dense(120, ReLU), Dense(10, Softmax). Phase 2 — Ensemble Stacking: CNN feature extractor + Random Forest / KNN / SVM / Naive Bayes / Decision Tree / Logistic Regression as base/meta learners.",
      "training_strategy": "Fine-tuning with frozen backbone weights. Adam optimizer (lr=0.0001), categorical cross-entropy loss, batch size 32, max 20 epochs.",
      "validation": "80/20 train-val split from training directory (seed=123). Separate held-out test set from /tomato/val/ (1,000 images).",
      "cross_validation": "Not applied — dataset size sufficient for holdout validation. Early stopping on val_loss used to prevent overfitting."
    }
  },
  "results": {
    "metrics": {
      "accuracy": "VGG16: 94.0% | InceptionV3: 93.7% | ResNet50: 93.1% | Custom CNN: 84.9%",
      "precision": "VGG16 macro avg: 0.94 | InceptionV3: 0.93 | ResNet50: 0.92",
      "recall": "VGG16 macro avg: 0.94 | InceptionV3: 0.93 | ResNet50: 0.93",
      "f1_score": "VGG16 macro avg: 0.94 | InceptionV3: 0.929 | ResNet50: 0.921 | Custom CNN: 0.843",
      "roc_auc": "Not computed — multiclass classification evaluated via confusion matrix and per-class classification report"
    },
    "key_findings": [
      "VGG16 achieves the best test accuracy (94.0%) with a smaller model size (~59MB) compared to InceptionV3 (~88MB), making it the optimal choice for Android deployment",
      "Transfer learning with ImageNet weights dramatically outperforms ensemble stacking (~94% vs ~76%), confirming end-to-end deep learning superiority for image classification",
      "Septoria Leaf Spot is consistently the hardest class to classify precisely across all models, likely due to visual similarity with Early Blight",
      "Yellow Leaf Curl Virus and Mosaic Virus achieve near-perfect F1 scores (0.98–0.99) due to their highly distinct visual signatures",
      "Ensemble stacking on CNN-extracted features underperforms because shallow classifiers cannot fully leverage the high-dimensional feature space optimized for end-to-end classification"
    ]
  },
  "features": [
    "Real-time tomato leaf disease classification into 10 classes",
    "Three pretrained CNN backbones benchmarked: InceptionV3, VGG16, ResNet50",
    "Ensemble stacking with 4 configurations (RF, KNN, SVM, NB, DT, Logistic Regression)",
    "TFLite model export for on-device Android inference (fully offline)",
    "Android app with live camera capture (CameraX) and gallery import",
    "Per-class confidence score display and disease info cards",
    "Confusion matrix and per-class classification report for all models"
  ],
  "tech_stack": [
    "Python 3.10",
    "TensorFlow 2.x / Keras",
    "Scikit-learn",
    "OpenCV (cv2)",
    "Pandas",
    "Matplotlib",
    "NumPy",
    "TensorFlow Lite",
    "Kotlin",
    "Jetpack Compose",
    "CameraX",
    "Android ML Kit"
  ],
  "project_structure": {
    "app": "android/app/src/main/java/com/tomatoscan/MainActivity.kt — Jetpack Compose UI, camera logic, TFLite inference trigger",
    "notebook": "Mobile_Tomato_Disease_Detection_using_CNN___ML.ipynb — Full training pipeline: data loading, model training, evaluation, TFLite export",
    "models": "models/ — Exported .tflite and .pbtxt files: 0.94_inception.tflite, 0.94_model_vgg.tflite, 0.94_model_resnet.tflite",
    "data": "/kaggle/input/tomatoleaf/tomato/ — Train and val splits loaded via tf.keras image_dataset_from_directory",
    "utils": "android/app/src/main/java/com/tomatoscan/ClassifierEngine.kt — TFLite model wrapper, preprocessing, softmax output parsing",
    "assets": "android/app/src/main/assets/ — model.tflite (active model), labels.txt (class name map)"
  },
  "usage": {
    "installation": [
      "git clone https://github.com/RaphaelNazareth/tomatoscan",
      "pip install tensorflow pandas matplotlib scikit-learn opencv-python",
      "Open Mobile_Tomato_Disease_Detection_using_CNN___ML.ipynb on Kaggle or locally",
      "For Android: copy .tflite model to android/app/src/main/assets/model.tflite",
      "Open android/ in Android Studio and run on device or emulator"
    ],
    "run": "jupyter notebook Mobile_Tomato_Disease_Detection_using_CNN___ML.ipynb — or run cells sequentially on Kaggle. For Android: ./gradlew installDebug",
    "interface": "Android app with two entry points: live camera capture via CameraX or image picker from gallery. Results displayed with disease name, confidence bar, top-3 predictions, and a Disease Info card with treatment recommendations."
  },
  "insights": [
    "Transfer learning with frozen ImageNet weights converges in 3–5 epochs, making training fast even on free-tier Kaggle GPUs",
    "VGG16's simpler convolutional architecture generalizes better to leaf texture patterns than InceptionV3's inception modules at 128×128 resolution",
    "Ensemble stacking accuracy plateaus around 75–76% regardless of meta-learner choice, suggesting the bottleneck is the quality of CNN features, not the classifier",
    "Early Blight remains the most misclassified disease, commonly confused with Septoria Leaf Spot — both cause small, dark-bordered lesions on lower leaves",
    "TFLite quantization (float16) reduces VGG16 model size from ~59MB to ~30MB with negligible accuracy loss, suitable for low-end Android devices"
  ],
  "future_work": [
    "Integrate MobileNetV3 or EfficientNet-Lite for a smaller footprint (~10–15MB) without sacrificing accuracy",
    "Add Grad-CAM visualization to highlight diseased regions on the leaf image",
    "Implement severity scoring (mild / moderate / severe) based on lesion coverage estimation",
    "Add multi-language support (Bahasa Indonesia, Spanish) for target farming communities",
    "Build a crowdsourced data collection mode within the app to continuously improve the model",
    "Deploy a lightweight Flask/FastAPI backend as an optional cloud fallback for older devices"
  ]
}
